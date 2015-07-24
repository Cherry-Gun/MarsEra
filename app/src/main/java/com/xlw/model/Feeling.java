package com.xlw.model;

import com.xlw.model.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table FEELING.
 */
public class Feeling {

    private Long id;
    private String content;
    private Long serverId;      // 服务器端id
    private Integer statusFlag; // 同步状态
    private long locationId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient FeelingDao myDao;

    private Location location;
    private Long location__resolvedKey;


    public Feeling() {
    }

    public Feeling(Long id) {
        this.id = id;
    }

    public Feeling(Long id, String content, Long serverId, Integer statusFlag, long locationId) {
        this.id = id;
        this.content = content;
        this.serverId = serverId;
        this.statusFlag = statusFlag;
        this.locationId = locationId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getFeelingDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public Integer getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(Integer statusFlag) {
        this.statusFlag = statusFlag;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    /** To-one relationship, resolved on first access. */
    public Location getLocation() {
        long __key = this.locationId;
        if (location__resolvedKey == null || !location__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LocationDao targetDao = daoSession.getLocationDao();
            Location locationNew = targetDao.load(__key);
            synchronized (this) {
                location = locationNew;
            	location__resolvedKey = __key;
            }
        }
        return location;
    }

    public void setLocation(Location location) {
        if (location == null) {
            throw new DaoException("To-one property 'locationId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.location = location;
            locationId = location.getId();
            location__resolvedKey = locationId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}