/*
 *   Copyright (c) 2022 Joe Watson SBF
 *   All rights reserved.
 *   GitHub Profile :  https://github.com/joe-watson-sbf
 */
import { Button, Popover } from 'react-bootstrap';
import React from 'react'
import OverlayTrigger from 'react-bootstrap/OverlayTrigger';
import Form from 'react-bootstrap/Form'

const Formulaire = ({ children }) => {

    const handleClick = (event)=>{
        event.preventDefault();
        console.log(event.target.formBasicIsbn)
    }

    const Formulario = () => (
        <Form>

            <Form.Group className="mb-3" controlId="formBasicTitle">
                <Form.Control type="text" placeholder="Enter the title" />
            </Form.Group>

            <Form.Group className="mb-3" controlId="formBasicType">
                <Form.Control type="text" placeholder="Enter the type" />
            </Form.Group>

            <Form.Group className="mb-3" controlId="formBasicAuthor">
                <Form.Control type="text" placeholder="Enter the author" />
            </Form.Group>

            <Button variant="success" type="submit" onClick={handleClick}>
                SAVE
            </Button>

        </Form>
    )

    return (
        <OverlayTrigger trigger="click" key="top" placement="bottom" overlay={
            <Popover id={"popover-positioned-bottom"}>
                <Popover.Header as="h3">SAVE A NEW BOOK</Popover.Header>
                <Popover.Body>
                    <Formulario/>
                </Popover.Body>
            </Popover>
        }>
            {children}
        </OverlayTrigger>
    )
}

export default Formulaire