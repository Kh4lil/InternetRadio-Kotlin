# InternetRadio-Kotlin


App 3
Internet Radio App

Overview

The purpose of this App is to allow the playing of  Internet Radio channels as selected and configured by the user. A list of initial  Internet Radio station callLetters (same as App2)  followed by the corresponding streaming audio URLs are provided below:

Station Call Letters:  KABC, KARN-AM, KARN-FM, KDXE, KLAL, KURB, WBAP, WFAN, WLS,
WWTN, WWYT

The corresponding URLs (same as APP2) are given below:

http://playerservices.streamtheworld.com/api/livestream-redirect/kabcam.mp3
http://playerservices.streamtheworld.com/api/livestream-redirect/karnam.mp3
http://playerservices.streamtheworld.com/api/livestream-redirect/karnfm.mp3"
http://playerservices.streamtheworld.com/api/livestream-redirect/kdxefm.mp3
http://playerservices.streamtheworld.com/api/livestream-redirect/klalfm.mp3
http://playerservices.streamtheworld.com/api/livestream-redirect/kurbfm.mp3
http://playerservices.streamtheworld.com/api/livestream-redirect/wbapam.mp3
http://playerservices.streamtheworld.com/api/livestream-redirect/wfanam.mp3
http://playerservices.streamtheworld.com/api/livestream-redirect/wlsam.mp3
http://playerservices.streamtheworld.com/api/livestream-redirect/wwtnfm.mp3
http://playerservices.streamtheworld.com/api/livestream-redirect/wwytfm.mp3


The App biggest difference between App2, is that this App  will also allow the user to add channels as desired (no limit to the number of channels is specified). The URL does not have to be in the streamtheworld format given above.

The App is to be implemented using  NavigationControllers as shown below:




The 1st (leftmost) bottom navigation view  item should be a custom  item called Home
The middle bottom navigation view item should be a custom  named Config
The last (rightmost) bottom navigation view item should be a custom  item named Channels

The following images are standard bottom naviagtion vew images and are provided at Blackboard.

The left most image is specified by ic_home_black_24dp.xml
The middle image is specified by ic_build_black_24dp.xml
The right image is specified by baseline_radio_black+_24dp.png










The HomeFragment

The 1st Fragment  displayed by the bottom navigationview should be named HomeFragment. The HomeFragment should display a slideShow illustrating the  images from App2 and stored in slideShow.zip:

..All others follow.


The slideshow should display each image for appx 3 seconds. The slideshow should rotate the 3 images continuously for an indefinite period of time. You can display the images, in any order you like – displaying them in alphabetical order is recommended – KABC, KARN-AM, KARN-FM, KLAL, KURB, ...WXYT


The Channel Fragment

Pressing the rightmost button should display the initial set of radio channels managed by the ChannelFragment Fragment. The buttons must be scrollable.


The television station callLetters should correspond to the 1st set of station call letters provided on page 1.

An example screen is shown below:

For this example There are  more buttons not shown.  scrolling will show additionalbuttons – the buttons must be scrollable in both directions)



Pressing any of the buttons shown above will result in an WebView playing the corresponding URL (shown on page 1)  as shown below:

The streaming audio will play continuously until the user presses the “Back” button. Upon pressing “Back”, the previous Fragment  (ChannelFragment) will be displayed again as shown below:









The Config Fragment

Pressing the middle tab of the bottom navigation view – named Config – should invoke the ConfigFragment Fragment  and display the following interface:




The  text fields correspond to a new  Station Call Letters and new URL as entered by the user. For this App, assume that the station call letters and url have not been previously set (i.e., the call letters/urls are not currently displayed  by the ChannelFragment view)

The user will be allowed to enter a new Station and URL as shown above:
UK648

The URL for the above example is:
http://sc6.radiocaroline.net:8040/mp3
Pressing “Submit” should display the following Alert box and means that this new Station/URL combination will be available when the Channel's Tab is selected.

Pressing the Channel's  tab should result in a new button labeled “UK 648” added as a button and displayed at the  bottom of the Scrollable View.

Pressing the newly added station – UK 648 for this example – will play the new URL.

This newly added station/url combination only has to exist for the duration of the current running of this App (it does not have to exist if the App is restarted).

The user can add as many new Stations/URLs as desired. Your app must automatically add a new button to the ChannelFragment. The newly added URL must play.

You will not need to use file storage in any way to implement this App.


Testing On Other Emulators
Be sure that your app runs on the following emulators:





Additional  URLs for Testing



Call Letters            URL
BBC                https://stream.live.vc.bbcmedia.co.uk/bbc_world_service
WNYC                https://fm939.wnyc.org/wnycfm-web
KCMP                https://current.stream.publicradio.org/current.mp3




What you Submit

Name your Android  project InternetRadio. Zip up the entire Android  project.


Grading
It’s important to provide the core functionality for the multi-view App as described.  You will not be graded on how exactly similar your App is to mine. Feel free to use different arrangements, different options, and
