import React, { useState } from "react"

const AuthContext = React.createContext({
    token:'',
    isLoggedIn: false,
    login : (token) => {},
    logout : () => {}
})




export const AuthContextProvider = props => {
    const storedToken = localStorage.getItem('token');
    
    let initialToken ;

    if(storedToken){
        initialToken=storedToken;
    }

    const [token,setToken] = useState(initialToken);

    const userIsAuth = !!token;

    const loginHandler = (token) => {
        console.log(token);
        setToken(token);
        localStorage.setItem("token", token);

    }

    const logoutHandler = () => {
        setToken(null);
        localStorage.removeItem("token");
    }

    const contextValue = {
        token:token,
        isLoggedIn: userIsAuth,
        login: loginHandler,
        logout: logoutHandler
    };

    return <AuthContext.Provider value={contextValue}>
        {props.children}
    </AuthContext.Provider>
}

export default AuthContext;