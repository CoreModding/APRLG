package info.coremodding.aprlg.references;

import info.coremodding.aprlg.proxy.CommonProxy;

public class Reference {
	/**
	 * @author ethan
	 *
	 */
	public class Mod {
		public static final String ID = "APRLG";
		public static final String NAME = "A.P.R.L.G";
		/**
		 * The version of the mod.</br>
		 * Format: Major.Minor.Revision-α/β/rc/s-buildNumber</br>
		 * α - Lots of bugs/erros. Mechanics may/will change and may require world resets.</br>
		 * β - Less bugs/errors than α. Mechanics may/will change and may require world resets.</br>
		 * rc - Release Candidate. Very little bugs. Mechanics won't change much. World reset may be required.</br>
		 * s - Stable. Very little bugs. Mechnics won't change much. No world reset needed unless there is an MC update.</br>
		 */
		public static final String VERSION = "1.0.0-α-000";
		
		public static final String MC_VERSION = "1.7.2";
	}
	
	public class Proxy {
		public static final String COMMON_PROXY = "info.coremodding.aprlg.proxy.CommonProxy";
		public static final String CLIENT_PROXY = "info.coremodding.aprlg.proxy.CleintProxy";
	}
}