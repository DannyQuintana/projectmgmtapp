import React, { useState } from "react";
import { loginAPICall, storeToken, getToken, saveLoggedInUser } from "../services/AuthService";
import { useNavigate } from "react-router-dom";

const LoginComponent = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();

  async function handleLogin(e) {
    e.preventDefault();

    loginAPICall(email, password)
      .then((response) => {
        console.log(response.data);

        const token = "Bearer " + response.data.accessToken;
        storeToken(token);
        saveLoggedInUser(email);

        navigate("/projects");
        window.location.reload(false);
      })
      .catch((error) => {
        console.log(error);
        setErrorMessage(
          "Username or password is incorrect. If you have not been provided login credentials please contact the administrator for assistance."
        );
      });
  }

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3">
          <div className="card">
            <div className="card-header">
              <h2>Login</h2>
            </div>
            <div className="card-body">
              <div className="row mb-3">
                <label className="col-md-3 control-label" htmlFor="">
                  Email
                </label>
                <div className="col-md-9">
                  <input
                    type="email"
                    name="email"
                    className="form-control"
                    placeholder="Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                  />
                </div>
              </div>
              <div className="row mb-3">
                <label className="col-md-3 control-label" htmlFor="">
                  Password
                </label>
                <div className="col-md-9">
                  <input
                    type="password"
                    name="email"
                    className="form-control"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                  />
                </div>
              </div>
              {errorMessage && (
                <div className="row mb-3">
                  <div className="col-md-9 offset-md-2 text-danger">{errorMessage}</div>
                </div>
              )}
              <div className="form-group mb=3">
                <button className="btn btn-primary" onClick={(e) => handleLogin(e)}>
                  Login
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default LoginComponent;
