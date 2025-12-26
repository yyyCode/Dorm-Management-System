<template>
  <div>
    <div class="toolbar">
      <el-button type="primary" @click="handleAdd">添加床位</el-button>
    </div>
    
    <el-table :data="tableData" style="width: 100%" v-loading="loading">
      <el-table-column prop="dormId" label="宿舍ID" width="150" />
      <el-table-column prop="bedNumber" label="床位号" width="150" />
      <el-table-column prop="studentId" label="入住学生" width="150">
        <template #default="scope">
           {{ scope.row.studentId || '暂无' }}
        </template>
      </el-table-column>
      <el-table-column prop="isAssigned" label="状态">
        <template #default="scope">
          <el-tag :type="scope.row.isAssigned ? 'danger' : 'success'">
            {{ scope.row.isAssigned ? '已分配' : '空闲' }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200">
        <template #default="scope">
          <el-button 
            type="primary" 
            link 
            size="small" 
            @click="toggleStatus(scope.row)"
          >
            {{ scope.row.isAssigned ? '设为空闲' : '设为占用' }}
          </el-button>
          <el-button link type="danger" size="small" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="添加床位" v-model="dialogVisible" width="400px">
      <el-form :model="form" label-width="80px">
        <el-form-item label="宿舍ID">
          <el-input v-model="form.dormId"></el-input>
        </el-form-item>
        <el-form-item label="床位号">
          <el-input-number v-model="form.bedNumber" :min="1"></el-input-number>
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
import { bedApi } from '../api'
import { ElMessage, ElMessageBox } from 'element-plus'

const loading = ref(false)
const tableData = ref([])
const dialogVisible = ref(false)

const form = reactive({
  dormId: '',
  bedNumber: 1,
  isAssigned: false
})

const loadData = async () => {
  loading.value = true
  try {
    const res = await bedApi.list()
    tableData.value = res
  } finally {
    loading.value = false
  }
}

const handleAdd = () => {
  form.dormId = ''
  form.bedNumber = 1
  form.isAssigned = false
  dialogVisible.value = true
}

const toggleStatus = async (row) => {
  try {
    await bedApi.updateStatus(row.dormId, row.bedNumber, !row.isAssigned)
    ElMessage.success('状态更新成功')
    loadData()
  } catch (error) {
    // Error handled in interceptor
  }
}

const handleDelete = (row) => {
  ElMessageBox.confirm('确认删除该床位吗?', '提示', {
    type: 'warning'
  }).then(async () => {
    await bedApi.delete(row.dormId, row.bedNumber)
    ElMessage.success('删除成功')
    loadData()
  })
}

const submitForm = async () => {
  await bedApi.save(form)
  ElMessage.success('添加成功')
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
