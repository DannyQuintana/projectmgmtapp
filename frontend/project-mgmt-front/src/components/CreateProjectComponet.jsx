import React, { useState } from "react";
import { createProjectAPICall } from "../services/ProjectService";

export const CreateProjectComponet = () => {
  const [projectTitle, setTitle] = useState("");
  const [projectDescription, setDescription] = useState("");
  const [projectCommitDate, setDueDate] = useState("");
  const [error, setError] = useState("");

  function handleNewProjectForm(e) {
    e.preventDefault();

    // Form validation
    if (!projectTitle || !projectDescription || !projectCommitDate) {
      setError("Please fill out all fields.");
      return;
    }

    const currentDate = new Date();
    const selectedDate = new Date(projectCommitDate);

    if (selectedDate < currentDate) {
      setError("Due date must be in the future.");
      return;
    }

    setError(""); // Clear any previous error message

    const register = { projectTitle, projectDescription, projectCommitDate };

    console.log(register);

    createProjectAPICall(register)
      .then((response) => {
        console.log(response.data);
        // Optionally, you can reset the form fields here
        setTitle("");
        setDescription("");
        setDueDate("");
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
              <h2 className="text-center">Create New Project</h2>
            </div>
            <div className="card-body">
              <form>
                <div className="row mb-3">
                  <label className="col-md-3 control-label">Title</label>
                  <div className="col-md-9">
                    <input
                      type="text"
                      className="form-control"
                      placeholder="Project Title"
                      value={projectTitle}
                      onChange={(e) => setTitle(e.target.value)}
                    />
                  </div>
                </div>
                <div className="row mb-3">
                  <label className="col-md-3 control-label">Description</label>
                  <div className="col-md-9">
                    <input
                      type="text"
                      className="form-control"
                      placeholder="Project Description"
                      value={projectDescription}
                      onChange={(e) => setDescription(e.target.value)}
                    />
                  </div>
                </div>
                <div className="row mb-3">
                  <label className="col-md-3 control-label">Due Date</label>
                  <div className="col-md-9">
                    <input
                      type="date"
                      className="form-control"
                      placeholder="Project Due Date"
                      value={projectCommitDate}
                      onChange={(e) => setDueDate(e.target.value)}
                    />
                  </div>
                </div>
                {error && <p className="text-danger">{error}</p>}
                <div className="form-group mb=3">
                  <button className="btn btn-primary" onClick={(e) => handleNewProjectForm(e)}>
                    Submit
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
