import axios from "axios";
import { getToken } from "./AuthService";

const PROJECTS_REST_API_BASE_URL = "https://localhost:8080/api/projects";

axios.interceptors.request.use(
  function (config) {
    config.headers["Authorization"] = getToken();
    return config;
  },
  function (error) {
    return Promise.reject(error);
  }
);

export const getAllProjects = () => axios.get(PROJECTS_REST_API_BASE_URL);

export const createProjectAPICall = (projectObj) => axios.post(PROJECTS_REST_API_BASE_URL, projectObj);

export const getProjectByIdAPICall = (projectId) => axios.get(`${PROJECTS_REST_API_BASE_URL}/${projectId}`);

export const updateProjectAPICall = (projectId, project) =>
  axios.put(`${PROJECTS_REST_API_BASE_URL}/${projectId}`, project);

export const deleteProjectAPICall = (projectId) => axios.delete(`${PROJECTS_REST_API_BASE_URL}/${projectId}`);
