import axios from "axios";
import {environment} from "@app/environment";
import {useEffect, useState} from "react";
import {response} from "express";
import {Flex, FlexItem, Gallery, GalleryItem} from "@patternfly/react-core";
import {WineryCard} from "@app/Wineries/WineryCard";
import React from "react";
import {backendApi} from "@app/utils/axios-config";


export const WineryCardList = () => {

  const [wineries, setWineries] = useState([])

  useEffect(() => {
    const getWineriesListData = async () => {
      const result = await backendApi.get(`/winery/all`)
      setWineries(result)
      // wineries = result.data
    }
    getWineriesListData()
  }, []);

  // @ts-ignore
  return (
    <Flex style={{ margin: '15px' }}>
    {/*// <Gallery>*/}
      {wineries.map(winery => {
          console.log(winery)
        return(
        // @ts-ignore
          <FlexItem key={winery.id}><WineryCard  winery={winery} /></FlexItem>


      )})}
      </Flex>
  )

}
