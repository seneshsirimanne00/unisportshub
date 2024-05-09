import React from 'react';
import { Link } from 'react-router-dom';

import './common.css';

interface NavItem {
  path: string;
  label: string;
}

const navItems: NavItem[] = [
  { path: '/home', label: 'Home' },
  { path: '/profile', label: 'Profile' },
  { path: '/calender', label: 'Calender' },
  { path: '/sportsCategories', label: 'Sports Categories' },
  { path: '/results', label: 'Results' },
];

function Navbar() {
  return (
    <nav className='navbar-container'>
      <ul className='navbarItems'>
        {navItems.map((item) => (
          <li key={item.path}>
            <Link to={item.path}>{item.label}</Link>
          </li>
        ))}
      </ul>
    </nav>
  );
}

export default Navbar;
