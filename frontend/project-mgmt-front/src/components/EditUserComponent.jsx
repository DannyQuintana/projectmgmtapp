import React, { useState, useEffect } from "react";
import { getUserByIdAPICall, updateUserAPICall, deleteUserAPICall } from "../services/UserService";
import { useNavigate, useParams } from "react-router-dom";

const EditUserComponent = () => {
  const navigate = useNavigate();
  const { userId } = useParams();
  const [user, setUser] = useState({
    firstName: "",
    lastName: "",
    email: "",
  });
  const [errorMessage, setErrorMessage] = useState("");
  const [successMessage, setSuccessMessage] = useState("");

  useEffect(() => {
    const fetchUser = async () => {
      try {
        const response = await getUserByIdAPICall(userId);
        setUser(response.data);
      } catch (error) {
        console.error("Error fetching user: ", error);
      }
    };

    fetchUser();
  }, [userId]);

  function handleEditUserForm(e) {
    e.preventDefault();

    if (!user.firstName || !user.lastName || !user.email) {
      setErrorMessage("Please fill out all fields.");
      return;
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(user.email)) {
      setErrorMessage("Please enter a valid email address.");
      return;
    }

    updateUserAPICall(userId, user)
      .then((response) => {
        console.log(response.data);
        setSuccessMessage("User updated successfully!");
        setTimeout(() => {
          setSuccessMessage("");
          navigate("/teams");
        }, 3000);
      })
      .catch((error) => {
        console.error("Error updating user: ", error);
      });
  }

  function handleDeleteUser() {
    deleteUserAPICall(userId)
      .then((response) => {
        console.log(response.data);
        setSuccessMessage("User deleted successfully!");
        setTimeout(() => {
          setSuccessMessage("");
          navigate("/teams");
        }, 3000);
      })
      .catch((error) => {
        console.error("Error deleting user: ", error);
      });
  }

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUser((prevUser) => ({
      ...prevUser,
      [name]: value,
    }));
  };

  return (
    <div className="container mt-5">
      <div className="row">
        <div className="col-md-6 offset-md-3">
          <div className="card">
            <div className="card-header">
              <h2 className="text-center">Edit User</h2>
            </div>
            <div className="card-body">
              <form onSubmit={handleEditUserForm}>
                <div className="mb-3">
                  <label htmlFor="firstName" className="form-label">
                    First Name
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    id="firstName"
                    name="firstName"
                    value={user.firstName}
                    onChange={handleChange}
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="lastName" className="form-label">
                    Last Name
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    id="lastName"
                    name="lastName"
                    value={user.lastName}
                    onChange={handleChange}
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="email" className="form-label">
                    Email
                  </label>
                  <input
                    type="email"
                    className="form-control"
                    id="email"
                    name="email"
                    value={user.email}
                    onChange={handleChange}
                  />
                </div>
                {errorMessage && <p className="text-danger">{errorMessage}</p>}
                {successMessage && <p className="text-success">{successMessage}</p>}
                <div className="d-grid gap-2">
                  <button type="submit" className="btn btn-primary">
                    Submit
                  </button>
                  <button type="button" className="btn btn-danger" onClick={handleDeleteUser}>
                    Delete
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

export default EditUserComponent;
