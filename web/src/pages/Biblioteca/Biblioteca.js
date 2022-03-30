/*
 *   Copyright (c) 2022 Joe Watson SBF
 *   All rights reserved.
 *   GitHub Profile :  https://github.com/joe-watson-sbf
 */
import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { getRessources } from '../../actions/bibliotecaActions'
import Alert from '../../component/Alert/Alert';
import Loading from '../../component/loading/Loading';
import RessourceTable from '../../component/Table/RessourceTable';

const Ressource = ({ dispatch ,loading, ressources, hasErrors }) => {

    useEffect(()=> {
        dispatch(getRessources());
    }, [dispatch])


    return (
        <div className='biblioteca'>

            {loading && 
                <div className='spinner-loading'>
                    <Loading/>
                </div>
            }

            {hasErrors && <Alert/> }

            {ressources && <RessourceTable data={ressources}/> }

        </div>
    )
}


const mapStateToProps = state => ({
    loading: state.biblioteca.loading,
    ressources: state.biblioteca.ressources,
    hasErrors: state.biblioteca.hasErrors
})

export default connect(mapStateToProps)(Ressource)