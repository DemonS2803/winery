import * as React from 'react';
import '@patternfly/react-core/dist/styles/base.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import { AppLayout } from '@app/AppLayout/AppLayout';
import { AppRoutes } from '@app/routes';
import '@app/app.css';
import {backendApi} from "@app/utils/axios-config";
import {BaseLoginPage} from "@app/Login/BaseLoginPage";
import {useState} from "react";
import ProtectedRoute from "@app/Login/ProtectedRoute";
import {Login} from "@patternfly/react-core";
import {AuthProvider} from "@app/Login/AuthContext";
import {Store} from "@app/Store/Store";

const App: React.FunctionComponent = () => {
  return (
    <>
      <AuthProvider>
        <Router>
          <Switch>
            <Route path="/login" component={BaseLoginPage} />
            <ProtectedRoute path="/" component={AppRoute} />
          </Switch>
        </Router>
      </AuthProvider>
    </>
  )
}
export default App;

const AppRoute: React.FunctionComponent = () => (
  <AppLayout>
    <AppRoutes />
  </AppLayout>
)
