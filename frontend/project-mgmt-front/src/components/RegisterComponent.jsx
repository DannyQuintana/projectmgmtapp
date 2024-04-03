import React, { useState } from "react";
import { registerAPICall } from "../services/AuthService";

const RegisterComponent = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  function handleRegistrationForm(e) {
    e.preventDefault();

    const register = { firstName, lastName, email, password };

    console.log(register);

    registerAPICall(register)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3">
          <div className="card">
            <div className="card-header">
              <h2 className="text-center">Registration</h2>
            </div>
            <div className="card-body">
              <form action="">
                <div className="row mb-3">
                  <label className="col-md-3 control-label" htmlFor="">
                    First Name
                  </label>
                  <div className="col-md-9">
                    <input
                      type="text"
                      name="firstName"
                      className="form-control"
                      placeholder="First Name"
                      value={firstName}
                      onChange={(e) => setFirstName(e.target.value)}
                    />
                  </div>
                </div>
                <div className="row mb-3">
                  <label className="col-md-3 control-label" htmlFor="">
                    Last Name
                  </label>
                  <div className="col-md-9">
                    <input
                      type="text"
                      name="lastName"
                      className="form-control"
                      placeholder="Last Name"
                      value={lastName}
                      onChange={(e) => setLastName(e.target.value)}
                    />
                  </div>
                </div>
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
              </form>
              <div className="form-group mb=3">
                <button className="btn btn-primary" onClick={(e) => handleRegistrationForm(e)}>
                  Submit
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default RegisterComponent;
