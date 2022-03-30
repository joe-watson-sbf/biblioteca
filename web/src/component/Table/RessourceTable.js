/*
 *   Copyright (c) 2022 Joe Watson SBF
 *   All rights reserved.
 *   GitHub Profile :  https://github.com/joe-watson-sbf
 */
import React from 'react'
import { Table, Button } from 'react-bootstrap'

const RessourceTable = ({ data, loanFunction }) => {

    const handleClik = (isbn)=>{
        console.log(isbn)
    }

    return (
        <Table responsive>
            <thead>
                <tr>
                    <th>ISBN</th>
                    <th>Title</th>
                    <th>Category</th>
                    <th>Type</th>
                    <th>Author</th>
                    <th>Available</th>
                    <th>Loan Date</th>
                </tr>
            </thead>
            <tbody>
                {data.map((item, index) => (
                    <tr key={index}>
                        <td> <strong> {item.isbn} </strong> </td>
                        <td> {item.title} </td>
                        <td> {item.category} </td>
                        <td> {item.typo} </td>
                        <td> {item.author} </td>
                        <td> 
                            {item.onLoan ? <Button variant="outline-dark" disabled>LOAN</Button> : 
                                <Button onClick={()=> handleClik(item.isbn)} 
                                variant="outline-success"> LOAN </Button>} 
                        </td>
                        <td> {item.onLoan ? item.loanDate.split('T')[0] : 'Available'} </td>
                    </tr>
                    
                ))}
                
            </tbody>
        </Table>
    )
}

export default RessourceTable