import * as React from 'react';
import { Route, RouteComponentProps, Switch, useLocation } from 'react-router-dom';
import { Dashboard } from '@app/Dashboard/Dashboard';
import { Support } from '@app/Support/Support';
import { GeneralSettings } from '@app/Settings/General/GeneralSettings';
import { ProfileSettings } from '@app/Settings/Profile/ProfileSettings';
import { NotFound } from '@app/NotFound/NotFound';
import { useDocumentTitle } from '@app/utils/useDocumentTitle';
import {Wineries} from "@app/Wineries/Wineries";
import {Vineyard} from "@app/Vineyard/Vineyard";
import {Batch} from "@app/Batch/Batch";
import {Store} from "@app/Store/Store";
import {CustomerBucket} from "@app/CustomerBucket/CustomerBucket";
import {BaseLoginPage} from "@app/Login/BaseLoginPage";
import {Admin} from "@app/Admin/Admin";

let routeFocusTimer: number;
export interface IAppRoute {
  label?: string; // Excluding the label will exclude the route from the nav sidebar in AppLayout
  /* eslint-disable @typescript-eslint/no-explicit-any */
  component: React.ComponentType<RouteComponentProps<any>> | React.ComponentType<any>;
  /* eslint-enable @typescript-eslint/no-explicit-any */
  exact?: boolean;
  path: string;
  title: string;
  routes?: undefined;
}

export interface IAppRouteGroup {
  label: string;
  routes: IAppRoute[];
}

export type AppRouteConfig = IAppRoute | IAppRouteGroup;


const adminRoutes: AppRouteConfig[] = [
  {
    component: Admin,
    exact: true,
    label: 'Administration',
    path: '/admin',
    title: 'Sudakov | Main Admin',
  }
];

const routes: AppRouteConfig[] = [

  {
    component: Wineries,
    exact: true,
    label: 'Wineries',
    path: '/wineries',
    title: 'Sudakov | Main Winery',
  },
  {
    component: Vineyard,
    exact: true,
    label: 'Vineyards',
    path: '/vineyards',
    title: 'Sudakov | Main Vineyards',
  },
  {
    component: Batch,
    exact: true,
    label: 'Batch',
    path: '/batches',
    title: 'Sudakov | Main Vineyards',
  },
  {
    component: Store,
    exact: true,
    label: 'Store',
    path: '/store',
    title: 'Sudakov | Main Store',
  },
  {
    component: CustomerBucket,
    exact: true,
    label: 'Bucket',
    path: '/bucket',
    title: 'Sudakov | Main Bucket',
  },
  {
    component: Admin,
    exact: true,
    label: 'Administration',
    path: '/admin',
    title: 'Sudakov | Main Admin',
  }
];

// a custom hook for sending focus to the primary content container
// after a view has loaded so that subsequent press of tab key
// sends focus directly to relevant content
// may not be necessary if https://github.com/ReactTraining/react-router/issues/5210 is resolved
const useA11yRouteChange = () => {
  const { pathname } = useLocation();
  React.useEffect(() => {
    routeFocusTimer = window.setTimeout(() => {
      const mainContainer = document.getElementById('primary-app-container');
      if (mainContainer) {
        mainContainer.focus();
      }
    }, 50);
    return () => {
      window.clearTimeout(routeFocusTimer);
    };
  }, [pathname]);
};

const RouteWithTitleUpdates = ({ component: Component, title, ...rest }: IAppRoute) => {
  useA11yRouteChange();
  useDocumentTitle(title);



  function routeWithTitle(routeProps: RouteComponentProps) {
    return <Component {...rest} {...routeProps} />;
  }

  return <Route render={routeWithTitle} {...rest} />;
};

const PageNotFound = ({ title }: { title: string }) => {
  useDocumentTitle(title);
  return <Route component={NotFound} />;
};

const flattenedRoutes: IAppRoute[] = routes.reduce(
  (flattened, route) => [...flattened, ...(route.routes ? route.routes : [route])],
  [] as IAppRoute[],
);

const AppRoutes = (): React.ReactElement => (
  <Switch>
    {flattenedRoutes.map(({ path, exact, component, title }, idx) => (
      <RouteWithTitleUpdates path={path} exact={exact} component={component} key={idx} title={title} />
    ))}
    <PageNotFound title="404 Page Not Found" />
  </Switch>
);

export { AppRoutes, routes, adminRoutes };
