import React, { useState, useEffect } from "react";
import { getAllUsersAPICall } from "../services/UserService";
import SearchComponent from "./SearchComponent";
import { checkRole } from "../services/AuthService";

const TeamListComponent = () => {
  const [users, setUsers] = useState([]);
  const [filteredUsers, setFilteredUsers] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const isAdminAuth = checkRole();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await getAllUsersAPICall();
        setUsers(response.data);
        setFilteredUsers(response.data);
      } catch (error) {
        console.log("Error fetching users: ", error);
      }
    };
    fetchData();
  }, []);

  const handleSearch = (search) => {
    setSearchTerm(search);
    const filtered = users.filter((user) => {
      return (
        user.firstName.toLowerCase().includes(search.toLowerCase()) ||
        user.lastName.toLowerCase().includes(search.toLowerCase()) ||
        user.email.toLowerCase().includes(search.toLowerCase())
      );
    });
    setFilteredUsers(filtered);
  };

  return (
    <div className="container">
      <h1>Team Members</h1>
      <div className="row">
        <div className="col-md-12 mb-4">
          <SearchComponent searchData={users} onSearch={handleSearch} />
        </div>
        {filteredUsers.length === 0 ? (
          <div className="col-md-12">
            <p>No results found.</p>
          </div>
        ) : (
          filteredUsers.map((user) => (
            <div className="col-md-4" key={user.id}>
              <div className="card mb-3">
                <div className="card-body">
                  <h5 className="card-title">
                    {user.firstName} {user.lastName}
                  </h5>
                  <p className="card-text">
                    <a href={`mailto:${user.email}`} className="card-link">
                      Contact
                    </a>
                  </p>
                  {isAdminAuth && (
                    <p className="card-text">
                      <a href={`/edituser/${user.id}`} className="card-link">
                        Edit
                      </a>
                    </p>
                  )}
                </div>
              </div>
            </div>
          ))
        )}
      </div>
    </div>
  );
};

export default TeamListComponent;
