<template>
  <div>
    <div class="toolbar">
      <el-button type="primary" @click="handleAdd">添加学生</el-button>
    </div>

    <el-table :data="tableData" style="width: 100%" v-loading="loading">
      <el-table-column prop="studentId" label="学号" width="120" />
      <el-table-column prop="name" label="姓名" width="120" />
      <el-table-column prop="gender" label="性别" width="80" />
      <el-table-column prop="birthDate" label="出生日期" width="120" />
      <el-table-column prop="grade" label="年级" width="120" />
      <el-table-column prop="dormId" label="宿舍号" width="100" />
      <el-table-column prop="bedNumber" label="床位号" width="100" />
      <el-table-column prop="phone" label="联系方式" />
      <el-table-column label="操作" width="150">
        <template #default="scope">
          <el-button link type="primary" size="small" @click="handleEdit(scope.row)">编辑</el-button>
          <el-button link type="danger" size="small" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog :title="dialogTitle" v-model="dialogVisible" width="500px">
      <el-form :model="form" label-width="80px">
        <el-form-item label="学号">
          <el-input v-model="form.studentId" :disabled="isEdit"></el-input>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-select v-model="form.gender">
            <el-option label="男" value="M"></el-option>
            <el-option label="女" value="F"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="出生日期">
          <el-date-picker v-model="form.birthDate" type="date" value-format="YYYY-MM-DD"></el-date-picker>
        </el-form-item>
        <el-form-item label="年级">
          <el-input v-model="form.grade"></el-input>
        </el-form-item>
        <el-form-item label="宿舍号">
          <el-input v-model="form.dormId"></el-input>
        </el-form-item>
        <el-form-item label="床位号">
          <el-input v-model="form.bedNumber"></el-input>
        </el-form-item>
        <el-form-item label="电话">
          <el-input v-model="form.phone"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="submitForm">确定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, reactive, onMounted } from 'vue'
import { studentApi } from '../api'
import { ElMessage, ElMessageBox } from 'element-plus'

const loading = ref(false)
const tableData = ref([])
const dialogVisible = ref(false)
const isEdit = ref(false)
const dialogTitle = ref('新增学生')

const form = reactive({
  studentId: '',
  name: '',
  gender: '',
  birthDate: '',
  grade: '',
  dormId: '',
  bedNumber: '',
  phone: ''
})

const loadData = async () => {
  loading.value = true
  try {
    const res = await studentApi.list()
    tableData.value = res
  } finally {
    loading.value = false
  }
}

const handleAdd = () => {
  isEdit.value = false
  dialogTitle.value = '新增学生'
  Object.keys(form).forEach(key => form[key] = '')
  dialogVisible.value = true
}

const handleEdit = (row) => {
  isEdit.value = true
  dialogTitle.value = '编辑学生'
  Object.assign(form, row)
  dialogVisible.value = true
}

const handleDelete = (row) => {
  ElMessageBox.confirm('确认删除该学生吗?', '提示', {
    type: 'warning'
  }).then(async () => {
    await studentApi.delete(row.studentId)
    ElMessage.success('删除成功')
    loadData()
  })
}

const submitForm = async () => {
  if (isEdit.value) {
    await studentApi.update(form)
  } else {
    await studentApi.save(form)
  }
  ElMessage.success('操作成功')
  dialogVisible.value = false
  loadData()
}

onMounted(() => {
  loadData()
})
</script>

<style scoped>
.toolbar {
  margin-bottom: 20px;
}
</style>
