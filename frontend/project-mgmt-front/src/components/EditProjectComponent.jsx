import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { getProjectByIdAPICall, updateProjectAPICall, deleteProjectAPICall } from "../services/ProjectService";

const EditProjectComponent = () => {
  const { projectId } = useParams();
  const navigate = useNavigate();
  const [project, setProject] = useState({
    projectTitle: "",
    projectDescription: "",
    projectProgress: "",
    projectCommitDate: "",
  });
  const [successMessage, setSuccessMessage] = useState("");

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await getProjectByIdAPICall(projectId);
        setProject(response.data);
        console.log(response.data);
      } catch (error) {
        console.log("Error fetching data: ", error);
      }
    };

    if (projectId) {
      fetchData();
    }
  }, [projectId]);

  const handleUpdateProject = async (e) => {
    try {
      e.preventDefault();

      console.log(project);

      const response = await updateProjectAPICall(projectId, project);
      console.log(response.data);
      setSuccessMessage("Project updated successfully!");
      setTimeout(() => {
        setSuccessMessage("");
        navigate(`/projects`);
      }, 3000); // Clear the success message after 3 seconds
    } catch (error) {
      console.error("Error updating task: ", error);
    }
  };

  const handleDeleteProject = async () => {
    try {
      const response = await deleteProjectAPICall(projectId);
      console.log(response.data);
      navigate(`/projects`);
    } catch (error) {
      console.error("Error deleting task: ", error);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProject((prevProject) => ({
      ...prevProject,
      [name]: value,
    }));
  };

  return (
    <div className="container">
      <h2 className="text-center">Edit Task</h2>
      <form onSubmit={handleUpdateProject}>
        <div className="mb-3">
          <label htmlFor="projectTitle" className="form-label">
            Project Name
          </label>
          <input
            type="text"
            className="form-control"
            id="projectTitle"
            name="projectTitle"
            value={project.projectTitle}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="projectDescription" className="form-label">
            Project Description
          </label>
          <input
            type="text"
            className="form-control"
            id="projectDescription"
            name="projectDescription"
            value={project.projectDescription}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="projectProgress" className="form-label">
            Project Progress
          </label>
          <select
            className="form-select"
            id="projectProgress"
            name="projectProgress"
            value={project.projectProgress}
            onChange={handleChange}
          >
            <option value="COMPLETE">Complete</option>
            <option value="IN_PROGRESS">In Progress</option>
            <option value="DELAYED">Delayed</option>
            <option value="HELP_REQUESTED">Help Requested</option>
          </select>
        </div>
        <div className="mb-3">
          <label htmlFor="projectCommitDate" className="form-label">
            Project Commit Date
          </label>
          <input
            type="date"
            className="form-control"
            id="projectCommitDate"
            name="projectCommitDate"
            value={project.projectCommitDate}
            onChange={handleChange}
          />
        </div>
        <button type="submit" className="btn btn-primary me-2">
          Update Project
        </button>
        <button type="button" className="btn btn-danger" onClick={handleDeleteProject}>
          Delete Project
        </button>
      </form>
    </div>
  );
};

export default EditProjectComponent;
