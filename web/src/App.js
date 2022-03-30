import React from 'react'
import { ThemeProvider } from 'react-bootstrap';
import NavBar from './component/NavBar/NavBar';
import Biblioteca from './pages/Biblioteca/Biblioteca';

const App = () => {


	return (
		<ThemeProvider breakpoints={['xxxl', 'xxl', 'xl', 'lg', 'md', 'sm', 'xs', 'xxs']}>
			<NavBar/>
			<Biblioteca/>
		</ThemeProvider>
	)
}

export default App
