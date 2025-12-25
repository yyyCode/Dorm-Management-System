import axios from 'axios'
import { ElMessage } from 'element-plus'

const service = axios.create({
  baseURL: '/api', // Proxy in vite.config.js will handle this
  timeout: 5000
})

service.interceptors.response.use(
  response => {
    return response.data
  },
  error => {
    console.error('Request Error:', error)
    ElMessage.error(error.message || 'Request Failed')
    return Promise.reject(error)
  }
)

export default service
