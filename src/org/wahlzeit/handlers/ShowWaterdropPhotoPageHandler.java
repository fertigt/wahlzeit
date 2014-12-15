package org.wahlzeit.handlers;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.UserSession;
import org.wahlzeit.model.waterdrops.WaterdropPhoto;
import org.wahlzeit.webparts.WebPart;

/**
 * Created by fertigt on 06/12/14.
 */
public class ShowWaterdropPhotoPageHandler extends ShowPhotoPageHandler
{
	@Override
	protected void makePhotoCaption(UserSession us, WebPart page)
	{
		WaterdropPhoto photo = (WaterdropPhoto)us.getPhoto();
		// String photoId = photo.getId().asString();

		WebPart caption = createWebPart(us, PartUtil.CAPTION_INFO_FILE);
		caption.addString(Photo.CAPTION, getPhotoCaption(us, photo));
		caption.addString(Photo.LOCATION, photo.getLocation());
		caption.addString(WaterdropPhoto.TECHNIQUE, photo.getWaterdrop().getTechnique().asString());
		caption.addString(WaterdropPhoto.FORM, photo.getWaterdrop().getForm().asString());
		caption.addString(WaterdropPhoto.INFLUENCE, photo.getWaterdrop()
														   .getInfluence()
														   .name());

		page.addWritable(Photo.CAPTION, caption);
	}
}
