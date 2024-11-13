import axios from 'axios'

class AxiosConfig {

  axiosInstance: any

  constructor (baseURL, headers = {}) {
    this.axiosInstance = axios.create({
      baseURL,
      headers,
    })
  }

  async get (endpoint, params = {}) {
    try {
      const response = await this.axiosInstance.get(endpoint, { params })
      return response.data
    } catch (error) {
      this.handleError(error)
    }
  }

  async getWithAddHeader (endpoint, addHeaders = {}, params = {}) {
    try {
      const response = await this.axiosInstance.get(endpoint, { headers: {}, params })
      return response.data
    } catch (error) {
      this.handleError(error)
    }
  }

  async post (endpoint, data) {
    try {
      const response = await this.axiosInstance.post(endpoint, data)
      return response.data
    } catch (error) {
      this.handleError(error)
    }
  }

  // Add other methods like put, delete as needed
  async put (endpoint, data) {
    try {
      const response = await this.axiosInstance.put(endpoint, data)
      return response.data
    } catch (error) {
      this.handleError(error)
    }
  }

  async delete (endpoint) {
    try {
      const response = await this.axiosInstance.delete(endpoint)
      return response.data
    } catch (error) {
      this.handleError(error)
    }
  }

  handleError (error) {
    console.error('API call error:', error)
    throw error
  }

  async checkLogin() {
    try {
      const response = await this.axiosInstance.get('/main/check')
      return response
    } catch (error) {
      localStorage.clear()
      return false
    }
  }
}

// Example usage:
export let backendApi = new AxiosConfig('http://localhost:8080/api', {
  'Authorization': 'Bearer ' + localStorage.getItem("token"),
  'Content-Type': 'application/json',
  'Accept': 'application/json',
  'Access-Control-Allow-Credentials': 'true',
  'Access-Control-Allow-Origin': '*'
})

export const createApi = () => {
  backendApi = new AxiosConfig('http://localhost:8080/api', {
    'Authorization': 'Bearer ' + localStorage.getItem("token"),
    'Content-Type': 'application/json',
    'Accept': 'application/json',
    'Access-Control-Allow-Credentials': 'true',
    'Access-Control-Allow-Origin': '*'
  })
}
