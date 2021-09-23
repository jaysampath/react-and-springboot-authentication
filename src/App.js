
import { Route, Switch , Redirect } from "react-router-dom";
import AuthForm from "./components/AuthForm";

import NewUserForm from "./components/NewUserForm";
import Layout from "./components/Layout";
import HomePage from "./components/HomePage";
import Profile from "./components/Profile";

function App() {
  return (
    <Layout >
      <Switch>
        <Route path="/" exact>
          <Redirect to="/login" />
        </Route>
        <Route path="/login" exact>
          <AuthForm />
        </Route>
        <Route path="/register" exact>
          <NewUserForm />
        </Route>
        <Route path="/home" exact>
          <HomePage />
        </Route>
        <Route path="/profile" exact>
          <Profile />
        </Route>
        <Route path="*">
           <p>Page not found. invalid url</p>
        </Route>
      </Switch>
    </Layout>
  );
}

export default App;
