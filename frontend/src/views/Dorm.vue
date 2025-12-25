<template>
  <div>
    <div class="toolbar">
      <el-button type="primary" @click="handleAdd">添加宿舍</el-button>
    </div>
    
    <el-table :data="tableData" style="width: 100%" v-loading="loading">
      <el-table-column prop="dormId" label="宿舍ID" width="150" />
      <el-table-column prop="building" label="宿舍楼" width="150" />
      <el-table-column prop="bedCount" label="床位数" />
      <el-table-column label="操作" width="150">
        <template #default="scope">
          <el-button link type="primary" size="small" @click="handleEdit(scope.row)">编辑</el-button>
          <el-button link type="danger" size="small" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog :title="dialogTitle" v-model="dialogVisible" width="500px">
      <el-form :model="form" label-width="80px">
        <el-form-item label="宿舍ID">
          <el-input v-model="form.dormId" :disabled="isEdit"></el-input>
        </el-form-item>
        <el-form-item label="宿舍楼">
          <el-input v-model="form.building"></el-input>
        </el-form-item>
        <el-form-item label="床位数">
          <el-input-number v-model="form.bedCount" :min="1"></el-input-number>
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
import { dormApi } from '../api'
import { ElMessage, ElMessageBox } from 'element-plus'

const loading = ref(false)
const tableData = ref([])
const dialogVisible = ref(false)
const isEdit = ref(false)
const dialogTitle = ref('新增宿舍')

const form = reactive({
  dormId: '',
  building: '',
  bedCount: 4
})

const loadData = async () => {
  loading.value = true
  try {
    const res = await dormApi.list()
    tableData.value = res
  } finally {
    loading.value = false
  }
}

const handleAdd = () => {
  isEdit.value = false
  dialogTitle.value = '新增宿舍'
  form.dormId = ''
  form.building = ''
  form.bedCount = 4
  dialogVisible.value = true
}

const handleEdit = (row) => {
  isEdit.value = true
  dialogTitle.value = '编辑宿舍'
  Object.assign(form, row)
  dialogVisible.value = true
}

const handleDelete = (row) => {
  ElMessageBox.confirm('确认删除该宿舍吗?', '提示', {
    type: 'warning'
  }).then(async () => {
    await dormApi.delete(row.dormId)
    ElMessage.success('删除成功')
    loadData()
  })
}

const submitForm = async () => {
  if (isEdit.value) {
    await dormApi.update(form)
  } else {
    await dormApi.save(form)
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
