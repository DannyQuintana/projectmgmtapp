import axios from "axios";
import { getToken } from "./AuthService";

const TASK_REST_API_BASE_URL = "https://localhost:8080/api/tasks";

axios.interceptors.request.use(
  function (config) {
    config.headers["Authorization"] = getToken();
    return config;
  },
  function (error) {
    return Promise.reject(error);
  }
);

export const getTasksAPICall = () => axios.get(TASK_REST_API_BASE_URL);

export const getAllTaskByProjectIdAPICall = (projectId) => axios.get(`${TASK_REST_API_BASE_URL}/project/${projectId}`);

export const createTaskAPICall = (task) => axios.post(TASK_REST_API_BASE_URL, task);

export const getTaskByIdAPICall = (taskId) => axios.get(`${TASK_REST_API_BASE_URL}/${taskId}`);

export const updateTaskAPICall = (taskId, task) => axios.put(`${TASK_REST_API_BASE_URL}/${taskId}`, task);

export const deleteTaskAPICall = (taskId) => axios.delete(`${TASK_REST_API_BASE_URL}/${taskId}`);
