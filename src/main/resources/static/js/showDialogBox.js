class DialogueBox {
    constructor(pictureUrl, dialogueText) {
        this.pictureUrl = pictureUrl;
        this.dialogueText = dialogueText;
        // work w/ Travis to insert this into the dom dynamically in the bottom left div
        /*                <div id="characterDialogueBox" class="dialogueBox">
                    <div class="characterDialogueBox">
                        <div>
                            <img class="characterDialoguePic" src="/images/character_pics/Cristian.png">
                        </div>
                    </div>
                    <div id="characterDialogue" class="characterDialogue">
                        Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                    </div>
                </div>
        */
    }

    showDialogue(textToDisplay) {
        this.dialogueText = textToDisplay;
        // Get the div that contains the dialogue window (It should be hidden to start)
        document.getElementById("characterDialogue").innerText = this.dialogueText;

        // Display the div (it's defaulted to display:none - change it to display:inline-block)
        document.getElementById("characterDialogueBox").style.display = "inline-block";
    }

    hideDialogue() {
        document.getElementById("characterDialogueBox").style.display = "none";
    }
}
