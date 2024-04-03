import axios from "axios";

const TASK_REST_API_BASE_URL = "http://localhost:8080/api/tasks";

export const getTasksAPICall = (tesksObj) => axios.get(TASK_REST_API_BASE_URL);

export const getAllTaskByProjectIdAPICall = (projectId) => axios.get(`${TASK_REST_API_BASE_URL}/project/${projectId}`);
