import React, { useState, useEffect } from "react";
import { getAllProjects } from "../services/ProjectService";
import { Link } from "react-router-dom"; // Import Link from React Router
import SearchComponent from "./SearchComponent";

const ProjectListComponent = () => {
  const [projects, setProjects] = useState([]);
  const [filteredProjects, setFilteredProjects] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");

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
  }, []);

  const handleSearch = (search) => {
    setSearchTerm(search);
    const filtered = projects.filter((project) => {
      return (
        project.projectTitle.toLowerCase().includes(search.toLowerCase()) ||
        project.projectDescription.toLowerCase().includes(search.toLowerCase()) ||
        project.projectCommitDate.toLowerCase().includes(search.toLowerCase()) ||
        project.projectDescription.toLowerCase().includes(search.toLowerCase())
      );
    });
    setFilteredProjects(filtered);
  };

  return (
    <div className="container">
      <h1>Projects</h1>
      <div className="row">
        <div className="col-md-12 mb-4">
          <SearchComponent searchData={projects} onSearch={handleSearch} />
        </div>
        {filteredProjects.length === 0 ? (
          <div className="col-md-12">
            <p>No results found.</p>
          </div>
        ) : (
          filteredProjects.map((project) => (
            <div className="col-md-4" key={project.projectId}>
              <div className="card mb-4">
                <div className="card-body">
                  <h5 className="card-title">{project.projectTitle}</h5>
                  <p className="card-text">{project.projectDescription}</p>
                  <p className="card-text">Status: {project.projectProgress}</p>
                  <p className="card-text">Due Date: {project.projectCommitDate}</p>
                  {/* Use Link to navigate to TaskListComponent */}
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
