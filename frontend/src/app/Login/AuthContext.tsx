import React, { createContext, useContext, useState, useEffect } from 'react';

// @ts-ignore
const AuthContext = createContext();

export const useAuth = () => {
  return useContext(AuthContext);
};

export const AuthProvider = ({ children }) => {
  const [token, setToken] = useState('');

  useEffect(() => {
    // Retrieve token from localStorage (or other storage mechanism)
    const savedToken = localStorage.getItem('token') || '';
    setToken(savedToken);
  }, []);

  const login = (newToken) => {
    localStorage.setItem('token', newToken);
    setToken(newToken);
  };

  const logout = () => {
    localStorage.removeItem('token');
    setToken('');
  };

  const value = {
    token,
    login,
    logout,
    isAuthenticated: !!token,
  };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};
