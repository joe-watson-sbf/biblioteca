/*
 *   Copyright (c) 2022 Joe Watson SBF
 *   All rights reserved.
 *   GitHub Profile :  https://github.com/joe-watson-sbf
 */
import * as actions from '../constant/constant';

export const initialState = {
    loading: false,
    hasErrors: false,
    ressources: null,
    redirect: null
}


export default function bibliotecaReducer(state = initialState, action) {
    switch(action.type){
        case actions.LOADING:
			return { ...state, loading: true }
		case actions.LOADED_SUCCESS:
			return { ...state, ...action.payload, loading: false, hasErrors: false }
		case actions.LOADED_FAILED:
			return { ...state, loading: false, hasErrors: true }
		default:
			return state
    }
}
