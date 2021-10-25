import React from "react";
import { Route,Switch, Redirect } from 'react-router-dom'
import { Provider } from 'react-redux'
import { Navi, Home } from "./common/index";
import { BackTracking, BruteForce, DivideConquer, DynamicConquer, Greedy } from "features/algorithms";
//import { Counter } from "features/counter";
import { CounterOld } from "features/counterOld";
import { Linear, NonLinear, Mathematics } from "features/datastructure/index";
import { TodoInput, TodoList, Todo } from "features/todos/index";
import { UserJoin, UserList, SignIn, SignUp } from "features/users/index";
import { store } from "./app/store";


const App = () => {
  return(
    <Provider store={store}>
    <Navi/>
      <Switch>
        <Route exact path = '/' component = {Home}/>
        <Redirect from='/home' to= { '/' }/>
        <Route exact path = '/counter-old' component = {CounterOld}/>
        <Route exact path = '/todo' component = {Todo}/>
        <Route exact path = '/sign-up' component = {SignUp}/>
        <Route exact path = '/mathematics' component = {Mathematics}/>
        <Route exact path = '/linear' component = {Linear}/>
        <Route exact path = '/nonLinear' component = {NonLinear}/>
        <Route exact path = '/back-tracking' component = {BackTracking}/>
        <Route exact path = '/brute-force' component = {BruteForce}/>
        <Route exact path = '/divide-conquer' component = {DivideConquer}/>
        <Route exact path = '/dynanmic-conquer' component = {DynamicConquer}/>
        <Route exact path = '/greedy' component = {Greedy}/>
      </Switch>
  </Provider>
  )
};
export default App;