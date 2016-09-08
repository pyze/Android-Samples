package com.pyze.samples.eventsampleandroid.pyzeutil;

import com.pyze.android.PyzeEvents;
import com.pyze.android.PyzeSceneFlow;

import java.lang.reflect.Method;

/**
 * Created by jesudas on 06/09/16.
 */
public class PyzeUtil {
    public static Class SelectedEventClass = null;
    public static Method SelectedEventMethod = null;
    private static final String ALPHA_NUM ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static Class getClassOfType(PyzeEventClass eventClass){
        Class selectedClassType = null;
        switch ((PyzeEventClass)eventClass) {
            case Account:
                selectedClassType = PyzeEvents.PyzeAccount.class;
                break;
            case Ad:
                selectedClassType = PyzeEvents.PyzeAd.class;
                break;
            case Advocacy:
                selectedClassType = PyzeEvents.PyzeAdvocacy.class;
                break;
            case Content:
                selectedClassType = PyzeEvents.PyzeContent.class;
                break;
            case Messaging:
                selectedClassType = PyzeEvents.PyzeMessaging.class;
                break;
            case InAppPurchaseRevenue:
                selectedClassType = PyzeEvents.PyzeInAppPurchaseRevenue.class;
                break;
            case Tasks:
                selectedClassType = PyzeEvents.PyzeTasks.class;
                break;
            case Social:
                selectedClassType = PyzeEvents.PyzeSocial.class;
                break;
            case CommerceDiscovery:
                selectedClassType = PyzeEvents.PyzeCommerceDiscovery.class;
                break;
            case CommerceCuratedList:
                selectedClassType = PyzeEvents.PyzeCommerceCuratedList.class;
                break;
            case CommerceWishList:
                selectedClassType = PyzeEvents.PyzeCommerceWishList.class;
                break;
            case CommerceBeacon:
                selectedClassType = PyzeEvents.PyzeCommerceBeacon.class;
                break;
            case CommerceCart:
                selectedClassType = PyzeEvents.PyzeCommerceCart.class;
                break;
            case CommerceItem:
                selectedClassType = PyzeEvents.PyzeCommerceItem.class;
                break;
            case CommerceCheckout:
                selectedClassType = PyzeEvents.PyzeCommerceCheckout.class;
                break;
            case CommerceShipping:
                selectedClassType = PyzeEvents.PyzeCommerceShipping.class;
                break;
            case CommerceBilling:
                selectedClassType = PyzeEvents.PyzeCommerceBilling.class;
                break;
            case CommercePayment:
                selectedClassType = PyzeEvents.PyzeCommercePayment.class;
                break;
            case ExplicitActivation:
                selectedClassType = PyzeEvents.PyzeExplicitActivation.class;
                break;
            case Gaming:
                selectedClassType = PyzeEvents.PyzeGaming.class;
                break;
            case HealthAndFitness:
                selectedClassType = PyzeEvents.PyzeHealthAndFitness.class;
                break;
            case Media:
                selectedClassType = PyzeEvents.PyzeMedia.class;
                break;
            case Bitcoin:
                selectedClassType = PyzeEvents.PyzeBitcoin.class;
                break;
            case CommerceRevenue:
                selectedClassType = PyzeEvents.PyzeCommerceRevenue.class;
                break;
            case Drone:
                selectedClassType = PyzeEvents.PyzeDrone.class;
                break;
            case WeatherAndForecast:
                selectedClassType = PyzeEvents.PyzeWeatherAndForecast.class;
                break;
            case Support:
                selectedClassType = PyzeEvents.PyzeSupport.class;
                break;
            case CommerceSupport:
                selectedClassType = PyzeEvents.PyzeCommerceSupport.class;
                break;
            case SceneFlow:
                selectedClassType = PyzeSceneFlow.class;
                break;
            case PyzeEvent:
                selectedClassType = PyzeEvents.class;
                break;
            default:
                break;
        }
        return selectedClassType;
    }
    public static String getRandomString(int len) {
        StringBuffer sb = new StringBuffer(len);
        for (int i=0;  i<len;  i++) {
            int ndx = (int)(Math.random()*ALPHA_NUM.length());
            sb.append(ALPHA_NUM.charAt(ndx));
        }
        return sb.toString();
    }
}
