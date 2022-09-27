import {showNotification} from "../messaging.js";

export default function About(props) {
    // language=HTML
    return `
<header>
    <h1 id="aboutHeader">About</h1>
</header>
<main>
    <div id="aboutInfo">
        <p>Searchable movies database brought to you by The Lunchroom Bandits</p> 
       
    </div>
</main>
    `;
}
export function AboutEvents() {
    showNotification("Hey, a message!", "danger");
}