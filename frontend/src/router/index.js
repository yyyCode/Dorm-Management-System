import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../views/Layout.vue'

const routes = [
  {
    path: '/',
    component: Layout,
    redirect: '/students',
    children: [
      {
        path: 'students',
        name: 'Students',
        component: () => import('../views/Student.vue'),
        meta: { title: '学生管理' }
      },
      {
        path: 'dorms',
        name: 'Dorms',
        component: () => import('../views/Dorm.vue'),
        meta: { title: '宿舍管理' }
      },
      {
        path: 'beds',
        name: 'Beds',
        component: () => import('../views/Bed.vue'),
        meta: { title: '床位管理' }
      },
      {
        path: 'fees',
        name: 'Fees',
        component: () => import('../views/Fee.vue'),
        meta: { title: '费用管理' }
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
