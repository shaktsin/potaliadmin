package com.potaliadmin.pact.dao.institute;

import com.potaliadmin.domain.institute.Institute;
import com.potaliadmin.pact.framework.BaseDao;

/**
 * Created by Shakti Singh on 12/6/14.
 */
public interface InstituteDao extends BaseDao {

  public Institute findById(Long id);

  public Institute deleteInstitute(Long id);

  public Institute saveInstitute();
}
