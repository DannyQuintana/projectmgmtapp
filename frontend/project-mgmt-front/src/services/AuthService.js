import axios from "axios";

const AUTH_REST_API_BASE_URL = "http://localhost:8080/api/auth";

export const registerAPICall = (registerObj) => axios.post(AUTH_REST_API_BASE_URL + "/register", registerObj);

export const loginAPICall = (email, password) => axios.post(AUTH_REST_API_BASE_URL + "/login", { email, password });

export const storeToken = (token) => localStorage.setItem("token", token);

export const getToken = () => localStorage.getItem("token");

export const saveLoggedInUser = (useremail, role) => {
  sessionStorage.setItem("authenticatedUser", useremail);
  sessionStorage.setItem("role", role);
};

export const isUserLoggedIn = () => {
  const useremail = sessionStorage.getItem("authenticatedUser");
  if (useremail == null) {
    return false;
  } else {
    return true;
  }
};

export const getLoggedInUser = () => {
  const useremail = sessionStorage.getItem("authenticatedUser");
  return useremail;
};

export const logout = () => {
  localStorage.clear();
  sessionStorage.clear();
};

export const checkRole = () => {
  let role = sessionStorage.getItem("role");
  if (role === "ROLE_ADMIN" && role != null) {
    return true;
  } else {
    return false;
  }
};
