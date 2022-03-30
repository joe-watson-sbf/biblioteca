/*
 *   Copyright (c) 2022 Joe Watson SBF
 *   All rights reserved.
 *   GitHub Profile :  https://github.com/joe-watson-sbf
 */

import axios from "axios";
import { LOADED_FAILED, LOADED_SUCCESS, LOADING } from "../constant/constant";

const URL_BASE = 'http://localhost:8080/api/library';


export const loading = () => ({ type: LOADING })

export const success = payload => ({ type: LOADED_SUCCESS, payload});

export const failed = () => ({ type: LOADED_FAILED })


export function getRessources(){
    return async dispatch => {
        dispatch(loading());
        const {data, error} = await axios.get(`${URL_BASE}`)
        if(data){
            dispatch(success({ressources: data}))
        }
        if(error){
            dispatch(failed())
        }
    }
}