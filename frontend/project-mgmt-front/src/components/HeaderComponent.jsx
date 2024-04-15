import React from "react";
import { NavLink } from "react-router-dom";
import { isUserLoggedIn, logout } from "../services/AuthService";
import { useNavigate } from "react-router-dom";

const HeaderComponent = () => {
  const isAuth = isUserLoggedIn();
  const navigator = useNavigate();

  function handleLogout() {
    logout();
    navigator("/login");
  }

  return (
    <div>
      <header className="fixed-top bg-dark bg-gradient p-2">
        <nav className="navbar navbar-expand-md navbar-dark bg-dark bg-gradient pt-0">
          <div className="text-center">
            <a href="http://localhost:5173/" className="navbar-brand">
              Project Management App
            </a>
          </div>
          <div className="collapse navbar-collapse">
            <ul className="navbar-nav">
              {isAuth && (
                <li className="nav-item">
                  <NavLink to="/projects" className="nav-link">
                    Projects
                  </NavLink>
                </li>
              )}
            </ul>
            <ul className="navbar-nav">
              {isAuth && (
                <li className="nav-item">
                  <NavLink to="/teams" className="nav-link">
                    Team
                  </NavLink>
                </li>
              )}
            </ul>
            <ul className="navbar-nav">
              {isAuth && (
                <li className="nav-item">
                  <NavLink to="/reports" className="nav-link">
                    Reports
                  </NavLink>
                </li>
              )}
            </ul>
          </div>
          <ul className="navbar-nav">
            {isAuth && (
              <li className="nav-item">
                <NavLink to="/register" className="nav-link">
                  Register
                </NavLink>
              </li>
            )}
          </ul>
          <ul className="navbar-nav">
            {!isAuth && (
              <li className="nav-item">
                <NavLink to="/login" className="nav-link">
                  Login
                </NavLink>
              </li>
            )}
            {isAuth && (
              <li className="nav-item">
                <NavLink to="/login" className="nav-link" onClick={handleLogout}>
                  Logout
                </NavLink>
              </li>
            )}
          </ul>
        </nav>
      </header>
    </div>
  );
};

export default HeaderComponent;
