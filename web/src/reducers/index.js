/*
 *   Copyright (c) 2022 Joe Watson SBF
 *   All rights reserved.
 *   GitHub Profile :  https://github.com/joe-watson-sbf
 */
import { combineReducers } from 'redux'
import bibliotecaReducer from "./bibliotecaReducer";

const rootReducer = combineReducers({
    biblioteca: bibliotecaReducer
})

export default rootReducer;