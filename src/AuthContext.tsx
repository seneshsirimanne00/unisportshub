import React, { createContext, useState, useContext } from 'react';

interface AuthContextValue {
  isLoggedIn: boolean;
  userId: string | null;
  setIsLoggedIn: React.Dispatch<React.SetStateAction<boolean>>;
  setUserId: React.Dispatch<React.SetStateAction<string | null>>;
}

export const AuthContext = createContext<AuthContextValue | null>(null);

export const useAuth = () => {
  const context = useContext(AuthContext);

  if (!context) {
    throw new Error('useAuth must be used within an AuthContext Provider');
  }

  return context;
};

export const AuthContextProvider: React.FC<{ children: React.ReactNode; value: AuthContextValue }> = ({
  children,
  value,
}) => {
  const [isLoggedIn, setIsLoggedIn] = useState(false); 
  const [userId, setUserId] = useState<string | null>(null); 


  return (
    <AuthContext.Provider value={{ isLoggedIn, userId, setIsLoggedIn, setUserId }}>
      {children}
    </AuthContext.Provider>
  );
};
