import hello_word from './hello';
import world_word from './world';
import _ from 'lodash';
import css from './style.css';
document.querySelector('#root').innerHTML = _.join([hello_word, world_word, "- index"], " ");