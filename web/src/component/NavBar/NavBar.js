/*
 *   Copyright (c) 2022 Joe Watson SBF
 *   All rights reserved.
 *   GitHub Profile :  https://github.com/joe-watson-sbf
 */
import React from 'react'
import { Navbar, Nav, Container } from 'react-bootstrap'
import Formulaire from '../Form/Formulaire'

const NavBar = () => {
    return (
        <>
            <Navbar bg="dark" variant="dark">
                <Container>
                    <Navbar.Brand href="#">Biblioteca</Navbar.Brand>
                    <Nav className="me-auto">
                        <Formulaire> 
                            <Nav.Link href='#'>Save New</Nav.Link>
                        </Formulaire>
                    </Nav>
                </Container>
            </Navbar>
            <br />
        </>
    )
}

export default NavBar