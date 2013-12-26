package org.oyanov.mathgame.client;

import org.oyanov.mathgame.shared.FieldVerifier;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MathGame implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	
	public void onModuleLoad(){

		// setLayout(new RowLayout(Orientation.VERTICAL));
		final HorizontalPanel mainPanel = new HorizontalPanel();
		// mainPanel.setLayoutData(new RowLayout(Orientation.H));
		// mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		RootPanel.get("gameContainer").add(mainPanel);
		mainPanel.setWidth("100%");
		mainPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);		
		
		populateLeftPanel(mainPanel);
		
		populateBattlePanel(mainPanel);
		
		populateBattleStatsPanel(mainPanel);

	}
	
	private void populateLeftPanel(Panel mainContainer){
		final VerticalPanel leftPanel = new VerticalPanel();
		// leftPanel.add(new HTML("<b>Left Panel:</b>"));
		leftPanel.add(new Button("Left Panel:"));
		leftPanel.setStyleName("leftPanel");
		leftPanel.setWidth("400px");
		// leftPanel.setWidth("20%");
		// leftPanel.setHorizontalAlignment(VerticalPanel.ALIGN_LEFT);
		mainContainer.add(leftPanel);
		
		final HorizontalPanel myStats = new HorizontalPanel();
		myStats.add(new Button("myStats"));
		leftPanel.add(myStats);
		final HorizontalPanel helpMaterials = new HorizontalPanel();
		helpMaterials.add(new Button("helpMaterials"));
		leftPanel.add(helpMaterials);
		final HorizontalPanel retreatOptions = new HorizontalPanel();
		retreatOptions.add(new Button("retreatOptions"));
		leftPanel.add(retreatOptions);
	}
	
	private void populateBattlePanel(Panel mainContainer){
		final VerticalPanel battleViewPanel = new VerticalPanel();
		mainContainer.add(battleViewPanel);
		battleViewPanel.setStyleName("battleViewPanel");
//		battleViewPanel.setWidth("20%");
//		battleViewPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
		battleViewPanel.add(new Button("battleViewPanel:"));
		
		// battle view
		final HorizontalPanel battleViewCrux = new HorizontalPanel();
		battleViewPanel.add(battleViewCrux);
		battleViewCrux.add(new Button("battleViewCrux"));
		final VerticalPanel battleViewMonster = new VerticalPanel();
		battleViewPanel.add(battleViewMonster);
		battleViewMonster.add(new Button("battleViewMonster"));
		
		// battle view:monster panel
		final HorizontalPanel battleViewMonsterUp = new HorizontalPanel();
		battleViewMonster.add(battleViewMonsterUp);
		battleViewMonsterUp.add(new Button("battleViewMonsterUp"));
		
		// battle view:monster:up panel
		final VerticalPanel battleViewMonsterUpLeftHand = new VerticalPanel();
		battleViewMonsterUp.add(battleViewMonsterUpLeftHand);
		battleViewMonsterUpLeftHand.add(new Button("battleViewMonsterUpLeftHand"));
		final HorizontalPanel battleViewMonsterUpLeftHandUp = new HorizontalPanel();
		battleViewMonsterUpLeftHand.add(battleViewMonsterUpLeftHandUp);
		battleViewMonsterUpLeftHandUp.add(new Button("battleViewMonsterUpLeftHandUp"));
		final HorizontalPanel battleViewMonsterUpLeftHandDown = new HorizontalPanel();
		battleViewMonsterUpLeftHand.add(battleViewMonsterUpLeftHandDown);
		battleViewMonsterUpLeftHandDown.add(new Button("battleViewMonsterUpLeftHandDown"));
		
		
		final VerticalPanel battleViewMonsterUpCenter = new VerticalPanel();
		battleViewMonsterUp.add(battleViewMonsterUpCenter);
		battleViewMonsterUpCenter.add(new Button("battleViewMonsterUpCenter"));
		
		
		// battle view:monster:up: center panel
		final HorizontalPanel battleViewMonsterUpCenterHead = new HorizontalPanel();
		battleViewMonsterUpCenter.add(battleViewMonsterUpCenterHead);
		battleViewMonsterUpCenterHead.add(new Button("battleViewMonsterUpCenterHead"));
		final HorizontalPanel battleViewMonsterUpCenterBreast = new HorizontalPanel();
		battleViewMonsterUpCenter.add(battleViewMonsterUpCenterBreast);
		battleViewMonsterUpCenterBreast.add(new Button("battleViewMonsterUpCenterBreast"));
		final HorizontalPanel battleViewMonsterUpCenterBowels = new HorizontalPanel();
		battleViewMonsterUpCenter.add(battleViewMonsterUpCenterBowels);
		battleViewMonsterUpCenterBowels.add(new Button("battleViewMonsterUpCenterBowels"));
		
		final VerticalPanel battleViewMonsterUpRightHand = new VerticalPanel();
		battleViewMonsterUp.add(battleViewMonsterUpRightHand);		
		battleViewMonsterUpRightHand.add(new Button("battleViewMonsterUpRightHand"));
		
		final HorizontalPanel battleViewMonsterUpRightHandUp = new HorizontalPanel();
		battleViewMonsterUpRightHand.add(battleViewMonsterUpRightHandUp);
		battleViewMonsterUpRightHandUp.add(new Button("battleViewMonsterUpRightHandUp"));
		final HorizontalPanel battleViewMonsterUpRightHandDown = new HorizontalPanel();
		battleViewMonsterUpRightHand.add(battleViewMonsterUpRightHandDown);
		battleViewMonsterUpRightHandDown.add(new Button("battleViewMonsterUpRightHandDown"));
		
		
		final HorizontalPanel battleViewMonsterLegs = new HorizontalPanel();
		battleViewMonster.add(battleViewMonsterLegs);
		battleViewMonsterLegs.add(new Button("battleViewMonsterLegs"));
		
		// battle view:monster:legs panel
		final VerticalPanel battleViewMonsterLeftLeg = new VerticalPanel();
		battleViewMonsterLegs.add(battleViewMonsterLeftLeg);
		battleViewMonsterLeftLeg.add(new Button("battleViewMonsterLeftLeg"));
		final VerticalPanel battleViewMonsterRightLeg = new VerticalPanel();
		battleViewMonsterLegs.add(battleViewMonsterRightLeg);
		battleViewMonsterRightLeg.add(new Button("battleViewMonsterRightLeg"));
		
		final HorizontalPanel battleOptions = new HorizontalPanel();
		battleViewPanel.add(battleOptions);
		battleOptions.add(new Button("battleOptions"));
		
		// battle view:battle options panel
		final VerticalPanel battleOptionsCommands = new VerticalPanel();
		battleOptions.add(battleOptionsCommands);
		battleOptionsCommands.add(new Button("battleOptionsCommands"));
		
		// battle view:battle options:commands panel
		final HorizontalPanel battleOptionsCommandsTitle = new HorizontalPanel();
		battleOptionsCommands.add(battleOptionsCommandsTitle);
		battleOptionsCommandsTitle.add(new Button("battleOptionsCommandsTitle"));
		final HorizontalPanel battleOptionsCommandsBody = new HorizontalPanel();
		battleOptionsCommands.add(battleOptionsCommandsBody);
		battleOptionsCommandsBody.add(new Button("battleOptionsCommandsBody"));
		
		// battle view:battle options:commands:body panel
		final VerticalPanel battleOptionsCommandControl = new VerticalPanel();
		battleOptionsCommandsBody.add(battleOptionsCommandControl);
		battleOptionsCommandControl.add(new Button("battleOptionsCommandControl"));
		final VerticalPanel battleOptionsCommandStrenthIndicator = new VerticalPanel();
		battleOptionsCommandsBody.add(battleOptionsCommandStrenthIndicator);
		battleOptionsCommandStrenthIndicator.add(new Button("battleOptionsCommandStrenthIndicator"));
		
		// battle view:battle options:commands:body: strenth commands panel
		final HorizontalPanel battleOptionsCommandIncreaseHitStrenth = new HorizontalPanel();
		battleOptionsCommandControl.add(battleOptionsCommandIncreaseHitStrenth);
		battleOptionsCommandIncreaseHitStrenth.add(new Button("battleOptionsCommandIncreaseHitStrenth"));
		final HorizontalPanel battleOptionsCommandStopOnThisLevel = new HorizontalPanel();
		battleOptionsCommandControl.add(battleOptionsCommandStopOnThisLevel);
		battleOptionsCommandStopOnThisLevel.add(new Button("battleOptionsCommandStopOnThisLevel"));
		final HorizontalPanel battleOptionsCommandDecreaseHitStrenth = new HorizontalPanel();
		battleOptionsCommandControl.add(battleOptionsCommandDecreaseHitStrenth);
		battleOptionsCommandDecreaseHitStrenth.add(new Button("battleOptionsCommandDecreaseHitStrenth"));
	
		// battle view:battle options panel
		final VerticalPanel battleOptionsInventory = new VerticalPanel();
		battleViewPanel.add(battleOptionsInventory);
		battleOptionsInventory.add(new Button("battleOptionsInventory"));
		
		// battle view:battle options panel:inventory
		final HorizontalPanel weaponsArmorTitle = new HorizontalPanel();
		battleOptionsInventory.add(weaponsArmorTitle);
		weaponsArmorTitle.add(new Button("weaponsArmorTitle"));
		final HorizontalPanel weaponsArmorContainer = new HorizontalPanel();
		battleOptionsInventory.add(weaponsArmorContainer);
		weaponsArmorContainer.add(new Button("weaponsArmorContainer"));
		
		// battle view:battle options panel:inventory: weapons armor container
		final VerticalPanel weapon = new VerticalPanel();
		weaponsArmorContainer.add(weapon);
		weapon.add(new Button("weapon"));
		final VerticalPanel shield = new VerticalPanel();
		weaponsArmorContainer.add(shield);
		shield.add(new Button("shield"));
		final VerticalPanel necklace = new VerticalPanel();
		weaponsArmorContainer.add(necklace);
		necklace.add(new Button("necklace"));
		final VerticalPanel armour = new VerticalPanel();
		weaponsArmorContainer.add(armour);
		armour.add(new Button("armour"));
		
		
		final HorizontalPanel elixirsTitle = new HorizontalPanel();
		battleOptionsInventory.add(elixirsTitle);
		elixirsTitle.add(new Button("elixirsTitle"));
		final HorizontalPanel elixirsContainer = new HorizontalPanel();
		battleOptionsInventory.add(elixirsContainer);
		elixirsContainer.add(new Button("elixirsContainer"));
		
		// battle view:battle options panel:inventory: elexirs container
		final VerticalPanel elixirSlot1 = new VerticalPanel();
		elixirsContainer.add(elixirSlot1);
		elixirSlot1.add(new Button("elixirSlot1"));
		final VerticalPanel elixirSlot2 = new VerticalPanel();
		elixirsContainer.add(elixirSlot2);
		elixirSlot2.add(new Button("elixirSlot2"));
		final VerticalPanel elixirSlot3 = new VerticalPanel();
		elixirsContainer.add(elixirSlot3);
		elixirSlot3.add(new Button("elixirSlot3"));
		final VerticalPanel elixirSlot4 = new VerticalPanel();
		elixirsContainer.add(elixirSlot4);
		elixirSlot4.add(new Button("elixirSlot4"));
	}
	
	/***
	 * populates battle stats(right) panel with controls
	 */
	private void populateBattleStatsPanel(Panel mainContainer){
		final VerticalPanel battleStatsPanel = new VerticalPanel();
		mainContainer.add(battleStatsPanel);
		 battleStatsPanel.setWidth("20%");
		 battleStatsPanel.setStyleName("battleStatsPanel");
		 battleStatsPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		 battleStatsPanel.add(new Button("battleStatsPanel:"));
		
		// battle stats panel
		final HorizontalPanel monsterHealthTitle = new HorizontalPanel();
		battleStatsPanel.add(monsterHealthTitle);
		monsterHealthTitle.add(new Button("monsterHealthTitle"));
		final HorizontalPanel monsterHealthIndicator = new HorizontalPanel();
		battleStatsPanel.add(monsterHealthIndicator);
		monsterHealthIndicator.add(new Button("monsterHealthIndicator"));
		final HorizontalPanel battleLogTitle = new HorizontalPanel();
		battleStatsPanel.add(battleLogTitle);
		battleLogTitle.add(new Button("battleLogTitle"));
		final HorizontalPanel battleLog = new HorizontalPanel();
		battleStatsPanel.add(battleLog);
		battleLog.add(new Button("battleLog"));
		final VerticalPanel timerPanel = new VerticalPanel();
		battleStatsPanel.add(timerPanel);
		timerPanel.add(new Button("timerPanel"));
		
		//  battle stats: Timer panel
		final HorizontalPanel timerTitle = new HorizontalPanel();
		timerPanel.add(timerTitle);
		timerTitle.add(new Button("timerTitle"));
		final HorizontalPanel timerDigital = new HorizontalPanel();
		timerPanel.add(timerDigital);
		timerDigital.add(new Button("timerDigital"));
		final HorizontalPanel timerProgress = new HorizontalPanel();
		timerPanel.add(timerProgress);
		timerProgress.add(new Button("timerProgress"));
	}
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoadOld() {
		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(String result) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);
	}
}
