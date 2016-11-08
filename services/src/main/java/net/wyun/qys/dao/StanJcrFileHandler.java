package net.wyun.qys.dao;

import org.exoplatform.commons.api.persistence.GenericDAO;

import net.wyun.qys.domain.standard.StanJcrFile;

public interface StanJcrFileHandler extends GenericDAO<StanJcrFile, Long> {
	StanJcrFile save(StanJcrFile s);
}
