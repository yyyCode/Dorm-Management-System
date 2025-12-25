<template>
  <div>
    <div class="toolbar">
      <el-button type="primary" @click="handleAdd">录入费用</el-button>
    </div>
    
    <el-table :data="tableData" style="width: 100%" v-loading="loading">
      <el-table-column prop="feeId" label="费用ID" width="200" show-overflow-tooltip />
      <el-table-column prop="studentId" label="学号" width="120" />
      <el-table-column prop="feeType" label="费用类型" width="150" />
      <el-table-column prop="amount" label="金额" width="120" />
      <el-table-column prop="payDate" label="缴费日期" width="120" />
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
          <el-input v-model="form.studentId"></el-input>
        </el-form-item>
        <el-form-item label="费用类型">
          <el-select v-model="form.feeType" allow-create filterable placeholder="选择或输入">
            <el-option label="住宿费" value="住宿费"></el-option>
            <el-option label="水电费" value="水电费"></el-option>
            <el-option label="罚款" value="罚款"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="金额">
          <el-input-number v-model="form.amount" :precision="2" :step="10"></el-input-number>
        </el-form-item>
        <el-form-item label="缴费日期">
          <el-date-picker v-model="form.payDate" type="date" value-format="YYYY-MM-DD"></el-date-picker>
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
import { feeApi } from '../api'
import { ElMessage, ElMessageBox } from 'element-plus'

const loading = ref(false)
const tableData = ref([])
const dialogVisible = ref(false)
const isEdit = ref(false)
const dialogTitle = ref('录入费用')

const form = reactive({
  feeId: '',
  studentId: '',
  feeType: '',
  amount: 0,
  payDate: ''
})

const loadData = async () => {
  loading.value = true
  try {
    const res = await feeApi.list()
    tableData.value = res
  } finally {
    loading.value = false
  }
}

const handleAdd = () => {
  isEdit.value = false
  dialogTitle.value = '录入费用'
  form.feeId = ''
  form.studentId = ''
  form.feeType = ''
  form.amount = 0
  form.payDate = new Date().toISOString().split('T')[0]
  dialogVisible.value = true
}

const handleEdit = (row) => {
  isEdit.value = true
  dialogTitle.value = '编辑费用'
  Object.assign(form, row)
  dialogVisible.value = true
}

const handleDelete = (row) => {
  ElMessageBox.confirm('确认删除该费用记录吗?', '提示', {
    type: 'warning'
  }).then(async () => {
    await feeApi.delete(row.feeId)
    ElMessage.success('删除成功')
    loadData()
  })
}

const submitForm = async () => {
  if (isEdit.value) {
    await feeApi.update(form)
  } else {
    await feeApi.save(form)
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
