import Vue from 'vue'
import Vuex from 'vuex'
import { IAppState } from './modules/app'
import { IGroupModels } from './model/sys/dict'
Vue.use(Vuex)

export interface IRootState {
  app: IAppState,
  dictGroup:IGroupModels
}

// Declare empty store first, dynamically register all modules later.
export default new Vuex.Store<IRootState>({})

