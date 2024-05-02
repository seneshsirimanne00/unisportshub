import { BrowserRouter, Routes, Route } from 'react-router-dom';

import './App.css';

// Import your route components
import Home from './pages/Home'; // Assuming your home page component is in Home.tsx
import About from './pages/About'; // Assuming your about page component is in About.tsx

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;

