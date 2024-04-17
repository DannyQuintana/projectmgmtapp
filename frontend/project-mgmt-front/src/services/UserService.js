import axios from "axios";

const USER_REST_API_BASE_URL = "http://localhost:8080/api/user";

export const getAllUsersAPICall = () => axios.get(USER_REST_API_BASE_URL);

export const getUserByIdAPICall = (userId) => axios.get(`${USER_REST_API_BASE_URL}/${userId}`);

export const createUserAPICall = (userData) => axios.post(USER_REST_API_BASE_URL, userData);

export const updateUserAPICall = (userId, userData) => axios.put(`${USER_REST_API_BASE_URL}/${userId}`, userData);

export const deleteUserAPICall = (userId) => axios.delete(`${USER_REST_API_BASE_URL}/${userId}`);
