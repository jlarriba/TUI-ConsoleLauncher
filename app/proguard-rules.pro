-keep public class es.jlarriba.txt.commands.main.raw.* { public *; }
-keep public abstract class es.jlarriba.txt.commands.main.generals.* { public *; }
-keep public class es.jlarriba.txt.commands.txtxt.raw.* { public *; }
-keep public class es.jlarriba.txt.managers.notifications.NotificationService
-keep public class es.jlarriba.txt.managers.notifications.KeeperService
-keep public class es.jlarriba.txt.managers.options.**
-keep class es.jlarriba.txt.tuils.libsuperuser.**
-keep class es.jlarriba.txt.managers.suggestions.HideSuggestionViewValues
-keep public class it.andreuzzi.comparestring2.**

-dontwarn es.jlarriba.txt.commands.main.raw.**

-dontwarn javax.annotation.**
-dontwarn javax.inject.**
-dontwarn sun.misc.Unsafe

-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

-dontwarn org.htmlcleaner.**
-dontwarn com.jayway.jsonpath.**
-dontwarn org.slf4j.**

-dontwarn org.jdom2.**