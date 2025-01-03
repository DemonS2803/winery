import React, {useState} from 'react';
import { Route, Redirect } from 'react-router-dom';
import { useAuth } from './AuthContext';
import {BaseLoginPage} from "@app/Login/BaseLoginPage";

const ProtectedRoute = ({ component: Component, ...rest }) => {
  // const { isAuthenticated } = useAuth();
  const [authenticated, setAuthenticated] = useState(false)
  // if (localStorage.getItem('token') !== null) {
  //   setAuthenticated(true)
  // console.log("setup auth by token!")
  // }

  // console.log(setAuthenticated)
  return (
    <Route
      {...rest}
      render={(props) =>
        authenticated ? (
          <Component {...props} />
        ) : (
          // <Redirect to="/login" />
          <BaseLoginPage setAuthenticated={setAuthenticated}/>
        )
      }
    />
  );
};

export default ProtectedRoute;
