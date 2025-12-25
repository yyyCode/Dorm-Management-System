import request from './request'

export const studentApi = {
  list: () => request.get('/students'),
  get: (id) => request.get(`/students/${id}`),
  save: (data) => request.post('/students', data),
  update: (data) => request.put('/students', data),
  delete: (id) => request.delete(`/students/${id}`)
}

export const dormApi = {
  list: () => request.get('/dorms'),
  get: (id) => request.get(`/dorms/${id}`),
  save: (data) => request.post('/dorms', data),
  update: (data) => request.put('/dorms', data),
  delete: (id) => request.delete(`/dorms/${id}`)
}

export const bedApi = {
  list: () => request.get('/beds'),
  get: (dormId, bedNumber) => request.get(`/beds/${dormId}/${bedNumber}`),
  save: (data) => request.post('/beds', data),
  updateStatus: (dormId, bedNumber, isAssigned) => request.put(`/beds/${dormId}/${bedNumber}?isAssigned=${isAssigned}`),
  delete: (dormId, bedNumber) => request.delete(`/beds/${dormId}/${bedNumber}`)
}

export const feeApi = {
  list: () => request.get('/fees'),
  get: (id) => request.get(`/fees/${id}`),
  save: (data) => request.post('/fees', data),
  update: (data) => request.put('/fees', data),
  delete: (id) => request.delete(`/fees/${id}`)
}
