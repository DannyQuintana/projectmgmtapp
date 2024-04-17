import React, { useState, useEffect } from "react";
import { getAllProjects } from "../services/ProjectService";
import { Link } from "react-router-dom";
import SearchComponent from "./SearchComponent";
import { checkRole } from "../services/AuthService";

const ProjectListComponent = () => {
  const [projects, setProjects] = useState([]);
  const [filteredProjects, setFilteredProjects] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const [isAdmin, setIsAdmin] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await getAllProjects();
        setProjects(response.data);
        setFilteredProjects(response.data);
      } catch (error) {
        console.log("Error fetching projects: ", error);
      }
    };

    fetchData();

    const adminStatus = checkRole();
    setIsAdmin(adminStatus);
  }, []);

  const handleSearch = (search) => {
    setSearchTerm(search);
    const filtered = projects.filter((project) => {
      return (
        project.projectTitle.toLowerCase().includes(search.toLowerCase()) ||
        project.projectDescription.toLowerCase().includes(search.toLowerCase()) ||
        project.projectCommitDate.toLowerCase().includes(search.toLowerCase()) ||
        project.projectProgress.toLowerCase().includes(search.toLowerCase())
      );
    });
    setFilteredProjects(filtered);
  };

  const getStatus = (status) => {
    switch (status) {
      case "Complete":
        return "bg-success text-white";
      case "In Progress":
        return "bg-info text-white";
      case "Delayed":
        return "bg-danger text-white";
      case "Help Requested":
        return "bg-warning text-dark";
      default:
        return "";
    }
  };

  return (
    <div className="container">
      <h1>Projects</h1>
      <div className="row">
        <div className={isAdmin ? "col-md-8 mb-4" : "col-md-12 mb-4"}>
          <SearchComponent searchData={projects} onSearch={handleSearch} />
        </div>
        {isAdmin && (
          <Link to="/createproject" className="col-md-4 mb-4 btn btn-primary">
            Add New Project
          </Link>
        )}
        {filteredProjects.length === 0 ? (
          <div className="col-md-12">
            <p>No results found.</p>
          </div>
        ) : (
          filteredProjects.map((project) => (
            <div className="col-md-4 mb-4" key={project.projectId}>
              <div className="card shadow">
                <div className="text-end bg-transparent">
                  {isAdmin && <Link to={`/editproject/${project.projectId}`}>Edit</Link>}
                </div>
                <div className="card-body">
                  <h5 className={`card-title text-uppercase ${getStatus(project.projectProgress)}`}>
                    {project.projectTitle}
                  </h5>
                  <p className="card-text">{project.projectDescription}</p>
                  <p className="card-text">Status: {project.projectProgress}</p>
                  <p className="card-text">Due Date: {project.projectCommitDate}</p>
                  <Link to={`/tasks/${project.projectId}`} className="btn btn-primary">
                    View Tasks
                  </Link>
                </div>
              </div>
            </div>
          ))
        )}
      </div>
    </div>
  );
};

export default ProjectListComponent;
