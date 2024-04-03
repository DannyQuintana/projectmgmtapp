import axios from "axios";

const PROJECTS_REST_API_BASE_URL = "http://localhost:8080/api/projects";

export const getAllProjects = (projectsObj) => axios.get(PROJECTS_REST_API_BASE_URL);
